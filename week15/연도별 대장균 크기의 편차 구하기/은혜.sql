SELECT YEAR(ED.DIFFERENTIATION_DATE) AS YEAR
    , ABS(ED.SIZE_OF_COLONY - G.MAX_SIZE) AS YEAR_DEV
    , ED.ID
FROM ECOLI_DATA ED
LEFT JOIN (
    SELECT YEAR(ED.DIFFERENTIATION_DATE) AS YEAR
            , MAX(ED.SIZE_OF_COLONY) AS MAX_SIZE
    FROM ECOLI_DATA ED
    GROUP BY YEAR(ED.DIFFERENTIATION_DATE) 
    ) G
ON YEAR(ED.DIFFERENTIATION_DATE) = G.YEAR
ORDER BY YEAR ASC, YEAR_DEV ASC
