SELECT 
    SUBSTR(PRODUCT_CODE FROM 1 FOR 2) AS CATEGORY, 
    COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY SUBSTR(PRODUCT_CODE FROM 1 FOR 2)