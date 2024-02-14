-- 코드를 입력하세요
#성분 타입(INGREDIENT_TYPE), 총주문량(TOTAL_ORDER)
SELECT I.INGREDIENT_TYPE, SUM(F.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF AS F
LEFT JOIN ICECREAM_INFO AS I Using(FLAVOR)
GROUP BY  I.INGREDIENT_TYPE
ORDER BY F.TOTAL_ORDER
