SELECT 
    h.HOUR,
    COALESCE(a.COUNT, 0) AS COUNT
FROM 
    (SELECT 0 AS HOUR UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 UNION SELECT 12 UNION SELECT 13 UNION SELECT 14 UNION SELECT 15 UNION SELECT 16 UNION SELECT 17 UNION SELECT 18 UNION SELECT 19 UNION SELECT 20 UNION SELECT 21 UNION SELECT 22 UNION SELECT 23) h
LEFT JOIN 
    (SELECT 
         HOUR(DATETIME) AS HOUR,
         COUNT(*) AS COUNT
     FROM 
         ANIMAL_OUTS
     GROUP BY 
         HOUR(DATETIME)) a
ON 
    h.HOUR = a.HOUR
ORDER BY 
    h.HOUR;
