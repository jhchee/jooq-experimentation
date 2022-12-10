DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS customer;

-- customer and product table
CREATE TABLE customer (
  id bigserial PRIMARY KEY,
  email VARCHAR(255) NOT null,
  metadata VARCHAR(255) NOT null
);

CREATE TABLE product (
  id          BIGSERIAL PRIMARY KEY,
  customer_id UUID  NOT NULL REFERENCES customer (id),
  sku         VARCHAR(255) NOT NULL
);

-- Log  table
DROP TABLE IF EXISTS log;
CREATE TABLE log (
	id bigserial NOT NULL,
	created_at TIMESTAMP(5) WITH TIME ZONE NOT NULL,
	content TEXT,
	PRIMARY KEY(created_at, id)
) PARTITION BY RANGE(created_at);

CREATE TABLE log_default partition OF log DEFAULT;
INSERT INTO "public"."log" ("created_at") VALUES (TIMESTAMP WITH TIME ZONE '2022-12-10 11:35:46.021438743+00:00')

