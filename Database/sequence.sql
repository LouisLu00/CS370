-- ----------------------------
-- Sequence structure for User_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."User_user_id_seq";
CREATE SEQUENCE "public"."User_user_id_seq"
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."User_user_id_seq" OWNER TO "root";

-- ----------------------------
-- Sequence structure for fridge_fridge_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."fridge_fridge_id_seq";
CREATE SEQUENCE "public"."fridge_fridge_id_seq"
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."fridge_fridge_id_seq" OWNER TO "root";

-- ----------------------------
-- Sequence structure for ingredients_ingredient_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."ingredients_ingredient_id_seq";
CREATE SEQUENCE "public"."ingredients_ingredient_id_seq"
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."ingredients_ingredient_id_seq" OWNER TO "root";