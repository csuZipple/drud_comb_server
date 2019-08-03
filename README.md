## 后端部署
- 打成jar包
- 利用putty连接服务器
- ```ps -ef | grep java``` 与 ```kill -s 9 pid``` 杀死前一个jar进程
- 后台启动新的jar包 ```nohup java -jar babyshark-0.0.1-SNAPSHOT.jar  > log.file  2>&1 &```
- 同步新的sql

