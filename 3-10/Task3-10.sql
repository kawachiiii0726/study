/* ■ [回答]と記載のある箇所へ、1〜8の各課題内容に沿ったSQL文を記述しなさい。 */

-- 1. Staffテーブルから「経理部」に所属する社員の情報をすべて抽出してください。
select name from staff
where section ='経理部' ; 

-- 2. 在庫(Stocksテーブル)の在庫数(Quantity)が10以上25未満のものを抽出して下さい。
select * from Stocks 
where quantity>=10 and quantity<25; 

-- 3. INTERSECT演算子を使用して、Order_Headerテーブルで合計値(Total)が5000以上10000未満のものを抽出して下さい。
SELECT A.SubTotal FROM Order_detail A WHERE A.SubTotal >=5000
INTERSECT
SELECT B.SubTotal FROM Order_detail B WHERE B.SubTotal < 10000;

-- 4. 「関東」エリアの全店舗情報を抽出して下さい。
select * from area
where areaname='関東';

-- 5. 在庫(Stocksテーブル)内の各商品の合計数量を抽出して下さい。
SELECT goodscode, SUM(quantity) FROM stocks
GROUP BY goodscode;

-- 6. 商品（Gods）テーブルから単価（UnitPrice)が5000円より高い商品の情報を全て抽出して下さい。
select * from goods
where unitprice>=5000;

-- 7. Shopテーブルの全ての店舗コード（Shopcode）、店舗名（Shopname）を、所在地（areaname）とあわせて抽出してください。
select shopcode,shopname,areaname from shop 
join area on shop.areacode= area.areacode;
-- 8. 「新宿」店の在庫数が10以上の商品の商品コード（GoodsCode）、商品名（GoodsName）、在庫数（quantity）を抽出して下さい。
select DB1.goodsname,DB2.quantity,DB2.goodscode from goods DB1,
(select goodscode,quantity from stocks where quantity>=10 and shopcode='001') DB2
where DB1.goodscode=DB2.goodscode;
