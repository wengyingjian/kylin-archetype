# kylin-archetype
 [kylin项目](https://github.com/wengyingjian/kylin)自动搭建脚手架

## 使用方法
```
mvn archetype:generate \
-DarchetypeGroupId=com.wengyingjian.kylin \
-DarchetypeArtifactId=kylin-archetype \
-DarchetypeVersion=1.0-SNAPSHOT \
-DarchetypeCatalog=http://nexus.wengyingjian.com/nexus/service/local/repositories/kylin-snapshots/content/archetype-catalog.xml \
-DarchetypeRepository=http://nexus.wengyingjian.com/nexus/content/repositories/kylin-snapshots \
-DgroupId=your.group.id \
-DartifactId=your-artifact-id \
-Dversion=YOUR-VERSION
```

