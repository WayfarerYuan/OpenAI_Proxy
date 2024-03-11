# OpenAI 代理服务 Docker 镜像

欢迎使用！这个仓库提供了一个用于转发请求到 OpenAI API 的代理服务 Docker 镜像，旨在提高 OpenAI 服务在不同地区的可访问性。

## 准备工作

开始之前，请确保你的系统上已安装 Docker。如果还没安装，可以从 [https://www.docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop) 下载。

## 如何使用

按照以下步骤，轻松启动你的 OpenAI 代理服务：

### 拉取镜像

使用以下命令从 Docker Hub 拉取镜像：

```bash
docker pull voyageryuan/openai_proxy:latest
```

### 运行容器
拉取镜像后，使用以下命令运行容器：
    
```bash
docker run -d -p 8080:8080 voyageryuan/openai_proxy:latest
```
这条命令会让容器在后台运行，并将容器的 8080 端口映射到本地的 8080 端口，这样你就可以通过 http://localhost:8080 访问代理服务了。

### 发送请求
代理服务运行起来后，你就可以通过这个代理向 OpenAI 的 API 发送请求了。这里有个使用 curl 的示例：

```bash
curl -X POST http://localhost:8080/cache/myKey -H "Content-Type: application/json" -d '"myValue"'
curl http://localhost:8080/cache/myKey    
```
你可以将内容替换成你想要转发给 OpenAI API 的实际请求内容。

### 自定义
这个 Docker 镜像预设了通用配置，但你完全可以根据需要进行调整，无论是扩展镜像还是修改源代码都行。

### 贡献
如果你有好的意见或建议，欢迎贡献！请随时通过项目的 GitHub 页面提交 pull 请求或开启 issue。
