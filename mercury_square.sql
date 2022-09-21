/*
 Navicat Premium Data Transfer

 Source Server         : 123
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : mercury_square

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 27/04/2022 20:37:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `account_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `account_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `account_icon` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像图片',
  `account_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `account_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `account_sex` bit(1) NOT NULL DEFAULT b'0' COMMENT '性别（男0，女1）',
  `account_type` bit(1) NOT NULL DEFAULT b'0' COMMENT '用户类型（普通用户为0，管理员为1）',
  `account_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态（离线0，在线1，封禁2）',
  `account_follow` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '关注列表',
  `account_favorite` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '收藏列表',
  `account_dynamic` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '动态列表',
  `account_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '消息通知列表',
  `account_history` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '浏览记录列表',
  `account_chat` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '私信',
  `account_readed_num` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '文章被阅读数',
  `account_liked_num` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '文章被点赞数',
  `account_collected_num` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '文章被收藏数',
  `account_followed_num` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '关注者数量',
  PRIMARY KEY (`account_id`) USING BTREE,
  UNIQUE INDEX `uk_account_phone`(`account_phone`) USING BTREE,
  UNIQUE INDEX `uk_account_name`(`account_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (4, '小水星_66', NULL, NULL, '13168162412', b'0', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `article_title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `article_author_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '作者名',
  `article_cover` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '封面图片',
  `article_publish_date` datetime(0) NULL DEFAULT NULL COMMENT '发布时间（now() / 2022-4-22 20:45:50）\r\n作为草稿就没有发布时间，为null',
  `article_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '文章内容',
  `article_digest` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '摘要（200字以内）',
  `article_label_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签id组',
  `article_model_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模块id组',
  `article_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态（0-未发布，1-已发布，2-已下架）',
  `article_link` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章链接（已发布后）',
  `article_browse_num` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '浏览量',
  `article_liked_num` int(0) UNSIGNED NULL DEFAULT 0 COMMENT '点赞数',
  `article_treaded_num` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '点踩数',
  `article_forwarded_num` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '转发数',
  `article_collected_num` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '收藏数',
  `article_comment_num` int(0) NULL DEFAULT NULL COMMENT '评论数',
  `article_comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '评论（json）',
  PRIMARY KEY (`article_id`) USING BTREE,
  INDEX `article_author_name`(`article_author_name`) USING BTREE,
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`article_author_name`) REFERENCES `account` (`account_name`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, 'Java Array.sort的六种常用方法总结', '小水星_66', NULL, '2022-04-23 12:00:00', '## Arrays.sort()的六种用法\n\n一：直接用，升序排序\n```java\n        /**\n         * 用法一，升序排序\n         */\n        int[] nums1 = new int[]{4, 6, 8, 0, 5, 9, 7, 2, 1, 3};\n        Arrays.sort(nums1);\n```\n二：传入参数 fromIndex、toIndex，部分升序排序\n```java\n        /**\n         * 用法二，部分升序排序\n         */\n        int[] nums2 = new int[]{4, 6, 8, 0, 5, 9, 7, 2, 1, 3};\n        Arrays.sort(nums2, 0, 3);\n```\n三：重写比较器Comparator，降序排序\n```java\n        /**\n         * 用法三，降序排序\n         */\n        Integer[] nums3 = new Integer[]{4, 6, 8, 0, 5, 9, 7, 2, 1, 3};\n        Arrays.sort(nums3, new Comparator<Integer>() {\n            @Override\n            public int compare(Integer o1, Integer o2) {\n                return o2 - o1;\n            }\n        });\n```\n四：结合二和三（传参 + 重写），部分降序排序\n```java\n        /**\n         * 用法四，部分降序排序\n         */\n        Integer[] nums4 = new Integer[]{4, 6, 8, 0, 5, 9, 7, 2, 1, 3};\n        Arrays.sort(nums4, 0, 3, new Comparator<Integer>() {\n            @Override\n            public int compare(Integer o1, Integer o2) {\n                return o2 - o1;\n            }\n        });\n```\n五：二维数组的特殊排序\n```java\n        /**\n         * 用法五，二维数组排序\n         * 根据nums5[i][0]排序, 若num5[i][0]相同，则根据nums5[i][1]排序\n         */\n        int[][] nums5 = new int[][]{{1, 3}, {1, 2}, {4, 5}, {3, 7}};\n        Arrays.sort(nums5, new Comparator<int[]>() {\n            public int compare(int[] a, int[] b){\n                if(a[0]==b[0]){\n                    return a[1] - b[1];\n                }else {\n                    return a[0] - b[0];\n                }\n            }\n        });\n```\n六：与五一样，写法不同\n\n```java\n        /**\n         * 用法六，与用法五一样，写法不同\n         */\n        int[][] nums6 = new int[][]{{1, 3}, {1, 2}, {4, 5}, {3, 7}};\n        Arrays.sort(nums6, (a,b) -> (a[0]==b[0] ? a[1] - b[1] : a[0] - b[0]));\n```\n\n**输出结果**\n![在这里插入图片描述](https://img-blog.csdnimg.cn/8f2ed2ba07174203b7e5ded8c49134c2.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NjUyMzc5NA==,size_16,color_FFFFFF,t_70)\n>`待补充`', '摘要', '[1,2,3]', '[1,2]', 1, 'http://ms/ms001', 453, 24, 3, 5, 3, 2, '{\r\n    \"comment\":[{\r\n        \"commentId\":\"1\",\r\n        \"accountId\":\"1\",\r\n        \"text\":\"写的真好\",\r\n        \"commentTime\":\"2022-4-23 14:19:12\",\r\n        \"likedNum\":\"520\",\r\n        \"second\":[{\r\n            \"accountId\":\"3\",\r\n            \"text\":\"我也觉得\",\r\n            \"toCommentId\":\"1\",\r\n            \"commentTime\":\"2022-4-23 14:20:12\",\r\n            \"likedNum\":\"12\"\r\n        },{\r\n            \"accountId\":\"4\",\r\n            \"text\":\"俺也觉得\",\r\n            \"toCommentId\":\"1\",\r\n            \"commentTime\":\"2022-4-23 14:21:12\",\r\n            \"likedNum\":\"12\"\r\n        }]\r\n    },{\r\n        \"commentId\":\"1\",\r\n        \"accountId\":\"1\",\r\n        \"text\":\"写的真好\",\r\n        \"commentTime\":\"2022-4-23 14:19:12\",\r\n        \"likedNum\":\"520\",\r\n        \"second\":[{\r\n            \"accountId\":\"3\",\r\n            \"text\":\"我也觉得\",\r\n            \"toCommentId\":\"1\",\r\n            \"commentTime\":\"2022-4-23 14:20:12\",\r\n            \"likedNum\":\"12\"\r\n        },{\r\n            \"accountId\":\"4\",\r\n            \"text\":\"俺也觉得\",\r\n            \"toCommentId\":\"1\",\r\n            \"commentTime\":\"2022-4-23 14:21:12\",\r\n            \"likedNum\":\"12\"\r\n        }]\r\n    }]\r\n}');
INSERT INTO `article` VALUES (2, 'Axios使用Post向Spring传递POJO对象的三种方法（@RequestBody与@RequestParam注解）', '小水星_66', NULL, '2022-04-23 13:45:37', '### 序\n在开始前，先介绍一下下面这两个方法\n##### JSON.stringify()\n将对象变成json格式的字符串\n\n* 例：JSON.stringify({ id：1，name：\"小明\" })\n转换后就变为：{ \"id\"：\"1\"，\"name\"：\"小明\"}\n\n##### this.$qs.stringify({})\n将参数拼接为url传参的形式\n\n* 例：this.$qs.stringify({id：1，name：\"小明\"})\n转换后就变为：id=1&name=小明\n\n>`（但实际上使用post方式传递时，参数值为中文时会进行url转码，否则会产生歧义）`\n\n\n### 一. 使用@RequestBody（传递单个对象适用）\nController控制层使用@RequestBody注解接收对象参数时：\n\n1. Axios需设置响应头参数context-type为application/json，设置方式与ajax不同，需写在headers内。\n\n2. 使用JSON.stringify(对象)，将需传递到后端的对象序列化成json格式的字符串。\n\n```javascript\nthis.＄axios({\n    method: \'post\',\n    url: \'/queryUser\',\n    headers:{\n    	\'Context-Type\': \'application/json\' // 1\n    },\n    data: JSON.stringify(this.user) // 2\n}).then((res) => {\n    console.log(res.data)\n});\n```\n\n3. Controller需在形参对象前加上@RequestBody注解，因为注解带有反序列化机制，可将前端送来的json格式的字符串反序列化并一一映射为对象的属性，从而构成后端可直接使用的pojo对象\n\n```java\n@RequestMapping(value = \'/queryUser\', method = RequestMethod.POST)\npublic void queryUser(@RequestBody User user) { // 3\n	// user可直接使用\n	System.out.print(user);\n}\n```\n\n### 二. 使用@RequestParam（传递多个对象适用）\nController控制层使用@RequestParam注解接收对象参数时：\n\n1. 在Axios中，先使用JSON.stringify()将需传递的对象转换为json格式的字符串，再使用this.$qs.stringify()转化为url传参形式的字符串\n\n```javascript\nthis.＄axios({\n    method: \'post\',\n    url: \'/queryUser\',\n    data: this.$qs.stringify({  // 1\n        user: JSON.stringify(this.user)\n    })\n}).then((res) => {\n    console.log(res.data)\n});\n```\n\n2. Controller使用@ResquestParam注解，形参并不直接写pojo对象，而是Map< String，Object>对象，然后使用其get(\"key\")方法得到前端作为url参数传递过来的json格式的object对象，使用toString转化为字符串后，利用第三方架包fastjson的JSON.ParseObject()将字符串转成后端直接使用的pojo对象\n\n```java\n@RequestMapping(value = \'queryUser\', method = RequestMethod.POST)\npublic void queryUser(@RequestParam Map<String, Object> param) { // 2\n// get(\"key\")方法得到前端作为url参数传递过来的json格式的object对象\nObject o = param.get(\"user\");\n// toString转成字符串\nString userStr = o.toString();\n// 三方架包fastjson转pojo对象\nUser user = JSON.parseObject(userStr, User.class);\n// 对象使用\nSystem.out.print(user);\n```\n\nJSON.parseObject()的依赖\n```xml\n<dependency>\n  <groupId>com.alibaba</groupId>\n  <artifactId>fastjson</artifactId>\n  <version>2.0.1</version>\n</dependency>\n```\n\n>` 若用此方法在Axios传递对象时，仅仅 this.$qs.stringify({user: this.user})，则会将user的每一个属性拆解拼接为url传参形式的串(user.id=1&user.name=小明)，后端就获取不到完整对象了`\n\n### 三. 无注解（传递单个对象适用）\n1. 无需设置响应头\n2. axios使用this.$qs.stringify()\n\n```javascript\nthis.＄axios({\n    method: \'post\',\n    url: \'/queryUser\',\n    data: this.$qs.stringify(user)\n}).then((res) => {\n    console.log(res.data)\n});\n```\n\n3. Controller形参处无需注解\n\n```java\n@RequestMapping(value = \'/queryUser\', method = RequestMethod.POST)\npublic void queryUser(User user) {\n	// user可直接使用\n	System.out.print(user);\n}\n```\n\n### 总结\n\n单个pojo对象可使用第一种和第三种方法，多个不同的pojo对象则可使用第二种方法\n\n>文章参考博主简述 @insaneh\n', '在开始前，先介绍一下下面这两个方法\n##### JSON.stringify()\n将对象变成json格式的字符串\n\n* 例：JSON.stringify({ id：1，name：\"小明\" })\n转换后就变为：{ \"id\"：\"1\"，\"name\"：\"小明\"}\n\n##### this.$qs.stringify({})\n将参数拼接为url传参的形式\n\n* 例：this.$qs.stringify({id：1，name：\"小明\"})\n转换后就变为：id=1&name=小明', '[1,2,3]', '[1,2]', 1, 'http://ms/ms002', 121, 30, 2, 8, 6, 2, '{\r\n    \"comment\":[{\r\n        \"commentId\":\"1\",\r\n        \"accountId\":\"1\",\r\n        \"text\":\"写的真好\",\r\n        \"commentTime\":\"2022-4-23 14:19:12\",\r\n        \"likedNum\":\"520\",\r\n        \"second\":[{\r\n            \"accountId\":\"3\",\r\n            \"text\":\"我也觉得\",\r\n            \"toCommentId\":\"1\",\r\n            \"commentTime\":\"2022-4-23 14:20:12\",\r\n            \"likedNum\":\"12\"\r\n        },{\r\n            \"accountId\":\"4\",\r\n            \"text\":\"俺也觉得\",\r\n            \"toCommentId\":\"1\",\r\n            \"commentTime\":\"2022-4-23 14:21:12\",\r\n            \"likedNum\":\"12\"\r\n        }]\r\n    },{\r\n        \"commentId\":\"1\",\r\n        \"accountId\":\"1\",\r\n        \"text\":\"写的真好\",\r\n        \"commentTime\":\"2022-4-23 14:19:12\",\r\n        \"likedNum\":\"520\",\r\n        \"second\":[{\r\n            \"accountId\":\"3\",\r\n            \"text\":\"我也觉得\",\r\n            \"toCommentId\":\"1\",\r\n            \"commentTime\":\"2022-4-23 14:20:12\",\r\n            \"likedNum\":\"12\"\r\n        },{\r\n            \"accountId\":\"4\",\r\n            \"text\":\"俺也觉得\",\r\n            \"toCommentId\":\"1\",\r\n            \"commentTime\":\"2022-4-23 14:21:12\",\r\n            \"likedNum\":\"12\"\r\n        }]\r\n    }]\r\n}');
INSERT INTO `article` VALUES (3, 'Java教程', '小水星_66', NULL, '2022-04-26 20:06:42', NULL, NULL, NULL, NULL, 1, NULL, 344, 0, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
