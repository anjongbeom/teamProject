


create table tal_order (
    order_no number primary key,
    order_date Date,
    member_id varchar2(100) references tal_member(member_id)
);

drop table tal_order;

create table tal_order_detail(
    order_detail_no number,
    order_product_amount number,
    order_state varchar2(1),
    fk_order_no number references tal_order(order_no),
    fk_product_id varchar2(100) references tal_product(product_id)
);

drop table tal_order_detail;

ALTER TABLE tal_product ADD PRIMARY KEY (product_id); 
ALTER TABLE tal_product DROP PRIMARY KEY;