Spark项目懒人包
==========

项目包含了Java，Scala和Python的简单例子，DummyCountScala和DummyCountJava以及dummycount.py进行分布式数羊到10000并打印10000 is 10000的无聊输出。

IDE党
---
编写Scala程序可使用Intellij IDEA
http://www.jetbrains.com/idea/
在启动界面选择Pmport project并选中项目目录
当你打开scala文件时请选择Add Framework Support并选择Scala


或者Scala IDE for Eclipse
http://scala-ide.org/
选择File->Import并选中项目目录
导入后右键选中导航栏中的项目并更改项目属性
Scala Compiler中选择Use Project Settings并选择Scala 2.11版本
同一页面Target JVM请选择JDK 1.7

编译使用版本为Spark 2.1 请需要其他版本的童鞋在pom文件中修改spark.version
编译
---
请使用
```
mvn clean package
```
成功编译后将在target目录下生成2个jar文件
一个后缀为jar-with-dependencies.jar另一个就是.jar
前者是将项目所需的依赖全部打包后者只包含项目本身的class文件。Hadoop、Spark的依赖不需要特别打包，但是如果你使用了其他类库需要打包，请选择-with-dependencies版本。

运行
---
假设你把jar和python文件放在Spark提交机的~/sparkTemplate下
cd到SPARK_HOME/bin目录下
Python:
```
./spark-submit --master yarn-client ~/sparkTemplate/dummycount.py
```
Java:
```
./spark-submit --master yarn-client --class com.pingcap.spark.DummyCountJava ~/sparkTemplate/spark-template-0.1.0-SNAPSHOT-jar-with-dependencies.jar
```
Scala:
```
./spark-submit --master yarn-client --class com.pingcap.spark.DummyCountScala ~/sparkTemplate/spark-template-0.1.0-SNAPSHOT-jar-with-dependencies.jar
```
