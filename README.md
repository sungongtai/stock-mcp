# Stock MCP 项目

这是一个基于 Spring Boot 和 Spring AI 的股票数据服务mcp server，提供股票相关的数据查询和分析功能。 
（仅用来学习mcp server的相关知识）

## 技术栈

- Java 21
- Spring Boot 3.4.4
- Spring AI 1.0.0-M7
- Maven
- Lombok

## 功能特性

- 股票实时交易信息查询
- 股票分时价格查询
- 公司详细信息查询
- 支持沪深两市股票数据

## 环境要求

- JDK 21 或更高版本
- Maven 3.6.0 或更高版本

## 配置方式

以cursor为例：
1. 打开 File -> Preferences -> Cursor Settings -> MCP
2. 点击 Add new 添加新配置
3. 将下面内容复制进mcp.json文件
4. 注意修改command路径为你本地实际的JDK 21安装路径
5. 修改args中的jar包路径为你本地实际编译后的jar包路径

{
  "mcpServers": {
    "stockServer": {
      "command": "C:/Users/Administrator/.jdks/ms-21.0.6/bin/java.exe",
      "args": ["-jar", "E:/IdeaProjects/stock-mcp/target/stock-mcp-0.0.1-SNAPSHOT.jar"]
    }
  }
}

## 使用说明

配置后 可询问大模型相关问题
- 获取股票实时交易信息
- 获取股票分时价格
- 获取公司详细信息
- 获取当前时间

![img1.png](src%2Fmain%2Fresources%2Fimage%2Fimg1.png)
![img2.png](src%2Fmain%2Fresources%2Fimage%2Fimg2.png)






