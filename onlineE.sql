UPDATE edu_teacher SET intro='ELON MASK', gmt_modified=NOW()
WHERE id=1;
select * from edu_subject a where a.id = '1178214681118568449';


SELECT
	a.id,
	a.title,
	a.price,
	a.lesson_num,
	a.cover,
	b.`name`,
	es1.title oneSubject,
	es2.title twoSubject 
FROM
	edu_course a
	LEFT JOIN edu_teacher b ON a.teacher_id = b.id
	LEFT JOIN edu_course_description c ON a.id = c.id
	LEFT JOIN edu_subject es1 ON a.subject_parent_id = es1.id
	LEFT JOIN edu_subject es2 ON a.subject_id = es2.id 
WHERE
	a.id = '1347069271531905026'