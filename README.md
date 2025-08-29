# cloudplus-tool
## 模块划分

```text
cloudplus-tool/
├── pom.xml
├── README.md
├── cloudplus-tool-core/          # 核心模块
│   ├── pom.xml
│   └── src/
├── cloudplus-tool-data/          # 数据源模块
│   ├── pom.xml
│   └── src/
├── cloudplus-tool-security/      # 安全模块
│   ├── pom.xml
│   └── src/
├── cloudplus-tool-web/           # Web模块
│   ├── pom.xml
│   └── src/
├── cloudplus-tool-common/        # 公共模块
│   ├── pom.xml
│   └── src/
└── cloudplus-tool-starter/       # 启动器模块
    ├── pom.xml
    └── src/
```

```mermaid
graph LR
    A[旧常量类] -->|问题| B[魔法值问题]
    A --> C[类型不安全]
    D[枚举方案] -->|解决| E[编译期检查]
    D --> F[集中管理业务逻辑]
    D --> G[消除条件分支]
```