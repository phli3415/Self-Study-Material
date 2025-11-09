from tortoise import BaseDBAsyncClient


async def upgrade(db: BaseDBAsyncClient) -> str:
    return """
        CREATE TABLE IF NOT EXISTS `students` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '学生ID,主键',
    `name` VARCHAR(50) NOT NULL COMMENT '学生姓名',
    `age` INT COMMENT '学生年龄,可为空',
    `email` VARCHAR(100) UNIQUE COMMENT '学生邮箱,唯一'
) CHARACTER SET utf8mb4 COMMENT='学生模型, 包含基本信息.';
CREATE TABLE IF NOT EXISTS `aerich` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `version` VARCHAR(255) NOT NULL,
    `app` VARCHAR(100) NOT NULL,
    `content` JSON NOT NULL
) CHARACTER SET utf8mb4;"""


async def downgrade(db: BaseDBAsyncClient) -> str:
    return """
        """
