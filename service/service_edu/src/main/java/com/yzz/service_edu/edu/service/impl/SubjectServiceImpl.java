package com.yzz.service_edu.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzz.commonutils.exception.YzzException;
import com.yzz.service_edu.edu.dto.OneSubjectDTO;
import com.yzz.service_edu.edu.dto.TwoSubjectDTO;
import com.yzz.service_edu.edu.entity.Subject;
import com.yzz.service_edu.edu.mapper.SubjectMapper;
import com.yzz.service_edu.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzz.service_edu.edu.vo.ExcelSubjectDataVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
@Slf4j
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

	@Resource
	private SubjectMapper subjectMapper;

	@Override
	public void addSubject(MultipartFile file) throws IOException {


		AnalysisEventListener<ExcelSubjectDataVO> analysisEventListener = new AnalysisEventListener<ExcelSubjectDataVO>() {

			@Override
			public void invoke(ExcelSubjectDataVO excelSubjectData, AnalysisContext analysisContext) {
				if(excelSubjectData == null){
					throw new YzzException(201, "表格数据为空！");
				}
				log.info("访问excel数据");
				//判断一级分类是否已经在数据中存在
				Subject subject = isOrNotOne(excelSubjectData.getOneSubjectName());
				if(subject == null){
					subject = new Subject();
					subject.setTitle(excelSubjectData.getOneSubjectName());
					subject.setParentId("0");
					subjectMapper.insert(subject);
				}
				//判断二级分类是否已经在数据中存在
				String pid = subject.getId();
				Subject subjectTwo = isOrNotTwo(excelSubjectData.getTwoSubjectName(), pid);
				if(subjectTwo == null){
					subjectTwo = new Subject();
					subjectTwo.setTitle(excelSubjectData.getTwoSubjectName());
					subjectTwo.setParentId(pid);
					subjectMapper.insert(subjectTwo);
				}

			}

			@Override
			public void doAfterAllAnalysed(AnalysisContext analysisContext) {

			}
		};
		InputStream inputStream = file.getInputStream();
		EasyExcel.read(inputStream, ExcelSubjectDataVO.class, analysisEventListener).sheet().doRead();
	}

	@Override
	public List<OneSubjectDTO> listSubject() {
		List<OneSubjectDTO> result = new ArrayList<>();
		QueryWrapper<Subject> queryWrapperOne = new QueryWrapper<>();
		QueryWrapper<Subject> queryWrapperTwo = new QueryWrapper<>();

		//获取全部一级课程
		queryWrapperOne.eq("parent_id","0");
		List<Subject> oneSubjectList = subjectMapper.selectList(queryWrapperOne);
		//获取全部二级课程
		queryWrapperTwo.ne("parent_id", "0");
		List<Subject> twoSubjectList = subjectMapper.selectList(queryWrapperTwo);

		//按照一级课程的id，获取对应的二级课程
		for (int i = 0; i < oneSubjectList.size(); i++) {
			OneSubjectDTO oneSubjectDTO = new OneSubjectDTO();
			List<TwoSubjectDTO> twoSubjectDTOList = new ArrayList<>();

			for (int j = 0; j < twoSubjectList.size(); j++) {

				if(oneSubjectList.get(i).getId().equals(twoSubjectList.get(j).getParentId())){
					//循环创建twoDTO，并添加到twoDTOlist中去
					TwoSubjectDTO twoSubjectDTO = new TwoSubjectDTO();

					BeanUtils.copyProperties(twoSubjectList.get(j), twoSubjectDTO);
					twoSubjectDTOList.add(twoSubjectDTO);
					//todo 这个地方为啥加上不行
//					twoSubjectList.remove(twoSubjectList.get(j));
				}
			}
			//将一个自定义类的属性给另一个自定义类
			BeanUtils.copyProperties(oneSubjectList.get(i), oneSubjectDTO);
			//将二级课程放进一级课程DTO的list
			oneSubjectDTO.setChildren(twoSubjectDTOList);
			result.add(oneSubjectDTO);
		}
		return result;
	}

	@Override
	public List<Subject> getlevelOneSubject() {
		QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("parent_id", "0");
		return subjectMapper.selectList(queryWrapper);
	}

	@Override
	public List<Subject> getLevelTwoByLevelOne(String id) {
		QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("parent_id", id);
		return subjectMapper.selectList(queryWrapper);
	}


	public Subject isOrNotOne(String name){
		QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("title", name);
		queryWrapper.eq("parent_id", "0");
		return subjectMapper.selectOne(queryWrapper);
	}

	public Subject isOrNotTwo(String name, String pid){
		QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("title", name);
		queryWrapper.eq("parent_id", pid);
		return subjectMapper.selectOne(queryWrapper);
	}
}
