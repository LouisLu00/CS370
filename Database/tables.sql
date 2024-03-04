-- ----------------------------
-- Create Tables in the schema and set up the primary keys and foreign keys
-- ----------------------------

-- Table structure for fridge
DROP TABLE IF EXISTS "public"."fridge";
CREATE TABLE "public"."fridge" (
  "fridge_id" int4 NOT NULL DEFAULT nextval('fridge_fridge_id_seq'::regclass),
  "user_id" int4,
  "ingredient_id" int4
)
;
ALTER TABLE "public"."fridge" OWNER TO "root";

-- Table structure for ingredients
DROP TABLE IF EXISTS "public"."ingredients";
CREATE TABLE "public"."ingredients" (
  "ingredient_id" int4 NOT NULL DEFAULT nextval('ingredients_ingredient_id_seq'::regclass),
  "name" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "category" varchar(100) COLLATE "pg_catalog"."default",
  "quantity" numeric,
  "expiry_date" date
)
;
ALTER TABLE "public"."ingredients" OWNER TO "root";

-- Table structure for user
DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user" (
  "user_id" int4 NOT NULL DEFAULT nextval('"User_user_id_seq"'::regclass),
  "username" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "public"."user" OWNER TO "root";

-- ----------------------------
-- set up primary keys and foreign keys
-- ----------------------------

-- Primary Key structure for table fridge
ALTER TABLE "public"."fridge" ADD CONSTRAINT "fridge_pkey" PRIMARY KEY ("fridge_id");

-- Primary Key structure for table ingredients
ALTER TABLE "public"."ingredients" ADD CONSTRAINT "ingredients_pkey" PRIMARY KEY ("ingredient_id");

-- Primary Key structure for table user
ALTER TABLE "public"."user" ADD CONSTRAINT "User_pkey" PRIMARY KEY ("user_id");

-- Foreign Keys structure for table fridge
ALTER TABLE "public"."fridge" ADD CONSTRAINT "fridge_ingredient_id_fkey" FOREIGN KEY ("ingredient_id") REFERENCES "public"."ingredients" ("ingredient_id") ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE "public"."fridge" ADD CONSTRAINT "fridge_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "public"."user" ("user_id") ON DELETE CASCADE ON UPDATE NO ACTION;