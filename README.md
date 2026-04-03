# Evolve Project Agent Skills | Evolve 项目 Agent 技能集

This repository is a collection of reusable agent skills for the Evolve IoT management platform. These skills are designed to provide AI agents with the specialized knowledge and standards required to maintain a consistent UI/UX and backend architecture.
本仓库是 Evolve IoT 管理平台的可复用 Agent 技能集合。这些技能旨在为 AI Agent 提供维护一致的 UI/UX 和后端架构所需的专业知识与标准。

## 📦 Available Skills | 可用技能

### 1. Cyber-Frontend-Design
Enterprise-grade UI/UX design system featuring high-contrast Cyan themes, extreme roundness, and professional CRUD topologies.
企业级“赛博科技” UI/UX 设计系统，涵盖高对比度青色主题、极致圆角及专业级 CRUD 页面拓扑。
- **Directory | 目录**: `cyber-frontend-design/`
- **Key Features | 核心特性**: Standardized theme tokens, standard Modals, professional list/pagination layouts.

### 2. Cyber-Backend-Design
Backend development standards for RuoYi-Vue3 architecture, including project-specific CAPTCHA customization and API contracts.
基于 RuoYi-Vue3 架构的后端开发标准，包含特定项目的验证码自定义及 API 契约规范。
- **Directory | 目录**: `cyber-backend-design/`
- **Key Features | 核心特性**: Cyber-Tech CAPTCHA producers, standard AjaxResult envelopes.

## 🚀 How to Install | 如何安装

You can install these skills using the Open Agent Skills CLI (`npx skills`).
您可以使用 Open Agent Skills CLI (`npx skills`) 安装这些技能。

### Install Frontend Skill | 安装前端技能
```bash
npx skills add joyven/cyber-design@cyber-frontend-design
```

### Install Backend Skill | 安装后端技能
```bash
npx skills add joyven/cyber-design@cyber-backend-design
```

## 🛠 Usage | 使用方法

Once installed, the agent can access the skills via the `.agents/skills/` directory in your project. Each skill contains a `SKILL.md` file that specifies the rules and workflows for the agent to follow.
安装完成后，Agent 可以通过项目中的 `.agents/skills/` 目录访问这些技能。每个技能都包含一个 `SKILL.md` 文件，规定了 Agent 需遵循的规则和工作流。

## 📄 License | 授权
MIT License
