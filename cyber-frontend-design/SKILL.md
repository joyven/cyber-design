---
name: cyber-frontend-design
description: Enterprise-grade "Cyber-Tech" UI/UX design system and architecture for IoT/Admin platforms. Includes project topology, API standards, and detailed design tokens. | 企业级“赛博科技” UI/UX 设计系统与架构规范，专为 IoT 及后台管理平台打造。包含项目拓扑、API 标准及详细的样式令牌。
---

# Cyber-Frontend-Design (IoT Evolve Frontend 架构与技能沉淀)

This skill provides a standardized workflow and technical specification for building React-based IoT platforms using the "Cyber-Tech" theme.
本技能为使用“赛博科技”主题构建基于 React 的 IoT 平台提供了标准化的工作流与技术规范。

## 1. Project Topology | 项目拓扑结构

Standard directory structure for high-maintainability:
高可维护性的标准目录结构：

| Path | Description |
|------|-------------|
| `src/components/ui/` | **Source of Truth** for core UI (Modal, Pagination, etc.) | 核心 UI 组件库（单一事实来源） |
| `src/components/` | Business-specific components (e.g., DeviceManagement.tsx) | 业务逻辑组件 |
| `src/styles/theme.config.ts` | **Mandatory** style tokens and atomic classes | **强制性**样式令牌与原子类配置 |
| `src/utils/request.ts` | Axios-based request wrapper with token injection | 基于 Axios 的请求封装与 Token 注入 |
| `skills/cyber-frontend-design/` | This skill package for agent guidance | 用于 Agent 引导的本技能包 |

## 2. API & Data Flow Standards | API 与数据流规范

### 2.1 Request/Response Envelope | 请求与响应外壳
All API interactions must follow the standard envelope:
所有 API 交互必须遵循标准外壳：

```json
{
  "code": 200,   // Status code (200=Success, 500=Error) | 状态码
  "msg": "Done", // Status message | 状态消息
  "data": {      // Payload | 数据负载
    "total": 100,
    "rows": [...] 
  }
}
```

### 2.2 Pagination Strategy | 分页策略
- **Frontend Mode**: Handle both nested (`data.rows`) and flat (`data`) arrays to ensure resilience. | 前端模式：同时处理嵌套和扁平数组以增强鲁棒性。
- **Params**: `pageNum` (default 1), `pageSize` (default 10). | 参数：页码与页大小。

## 3. UI/UX Design System | UI/UX 设计系统

### 3.1 Design Tokens | 样式令牌
**CRITICAL**: Strictly use `theme.config.ts` for all styling. | **核心规则**：严禁硬编码，必须使用配置。

- **Primary Color**: `#25ADB5` (Cyan/Teal). | **主色调**：青翠色。
- **Roundness**: `rounded-xl` (12px) for cards/buttons. | **圆角**：容器与按钮统一使用 `rounded-xl`。
- **Interaction**: Always include `active:scale-95 transition-all` for buttons. | **交互**：按钮必须包含点击缩放与平滑过渡。

### 3.2 Modal Specs | 弹窗规范
- **Header**: Large title + Lucide `X` icon. | **头部**：大号标题 + 关闭图标。
- **Body**: `p-6 pt-4` padding for content. | **主体**：内容区域标准间距。
- **Footer**: `border-t border-slate-100` with standard buttons. | **底部**：上边框线 + 标准化按钮。

## 4. Agent Workflow | Agent 工作流

### Progress Checklist | 进度检查表
```
Project Progress:
- [ ] Phase 1: Planning & Setup
  - [ ] Load theme.config.ts
  - [ ] Analyze component hierarchy
- [ ] Phase 2: Core UI Standardization
  - [ ] Apply THEME tokens to buttons/modals
  - [ ] Use shared ui components (Modal/ConfirmModal)
- [ ] Phase 3: Data Flow Implementation
  - [ ] Standardize API requests (utils/request)
  - [ ] Handle pagination (total/rows)
- [ ] Phase 4: Final Verification
  - [ ] Visual regression check (Layout, Colors)
  - [ ] API integration check
```

## 5. Critical Notes | 核心注意事项

- **No Hardcoding**: Never use hex codes directly in components. | **禁止硬编码**：禁止在组件中直接使用十六进制颜色。
- **Consistency**: All modals must use `backdrop-blur-sm` wrappers. | **一致性**：所有弹窗必须使用高斯模糊方案。
- **Bilingual**: Maintain bilingual documentation for cross-agent clarity. | **双语**：保持文档双语，确保跨 Agent 理解。

## References | 参考资料

- [theme.config.ts](theme.config.ts) - Style Tokens
- [examples/Modal.tsx](examples/Modal.tsx) - Standard Modal Sample
- [examples/ConfirmModal.tsx](examples/ConfirmModal.tsx) - Standard Confirmation Sample
