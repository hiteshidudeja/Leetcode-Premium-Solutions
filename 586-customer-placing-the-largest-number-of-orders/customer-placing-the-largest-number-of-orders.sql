# Write your MySQL query statement below
# max, group by 

select customer_number from Orders group by customer_number having count(*) = (
    select MAX(order_count) from (
        select count(*) as order_count from Orders group by customer_number
    ) t
)