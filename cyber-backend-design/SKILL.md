---
name: cyber-backend-design
description: Backend development standards for "Evolve-Admin" based on RuoYi-Vue3 architecture. Includes Cyber-Tech CAPTCHA customization and API contract standards. | 基于 RuoYi-Vue3 架构的 Evolve-Admin 后端开发标准。包含赛博科技验证码自定义及 API 契约规范。
---

# Cyber-Backend-Design (Evolve-Admin 后端架构与标准)

This skill provides a standardized technical specification for developing backend services on the Evolve-Admin platform.
本技能为在 Evolve-Admin 平台上开发后端服务提供了标准化的技术规范。

## 1. API Contract Standards | API 契约标准

### 1.1 Response Envelope | 响应封装
All API responses must follow the RuoYi-standard AjaxResult:
所有 API 响应必须遵循 RuoYi 标准的 AjaxResult：

```json
{
  "code": 200,   // Status | 状态
  "msg": "Done", // Message | 消息
  "data": {      // Payload | 数据负载
    "total": 100,
    "rows": [...] 
  }
}
```

### 1.2 Pagination | 分页
- Use `startPage()` or `getDataTable()` to handle pagination. | 使用 `startPage()` 或 `getDataTable()` 处理分页。
- Return `total` and `rows` for list queries. | 列表查询必须返回 `total` 和 `rows`。

## 2. Cyber-Tech CAPTCHA | 赛博科技验证码

### 2.1 Visual Standards | 视觉标准
- **Background**: Deep Navy Gradient with Cyan Grid Lines. | **背景**：深蓝渐变 + 青色科技网格。
- **Noise**: Clean digital glitch lines (No random dots). | **干扰**：简洁的数字线条（无随机散点）。
- **Primary Color**: Cyan (`37,173,181`) or White. | **主色调**：青色或纯白。

### 2.2 Implementation Classes | 实现类
- `com.evolve.framework.captcha.CyberTechBackground`
- `com.evolve.framework.captcha.CyberTechNoise`

## 3. Configuration & Security | 配置与安全

- **Security**: Jakarta EE 10 / Spring Security based.
- **Cache**: Redis for CAPTCHA tokens (`CacheConstants.CAPTCHA_CODE_KEY`).

## 4. Agent Workflow | Agent 工作流

### Progress Checklist | 进度检查表
```
Backend Progress:
- [ ] Phase 1: Planning & Setup
  - [ ] Analyze API requirements
  - [ ] Check security config
- [ ] Phase 2: Core Implementation
  - [ ] Apply API contract standards (AjaxResult)
  - [ ] Implement business logic / controllers
- [ ] Phase 3: UI-Sync Customization
  - [ ] Apply Cyber-Tech CAPTCHA style if required
- [ ] Phase 4: Final Verification
  - [ ] API integration tests
  - [ ] Security check
```

## References | 参考资料

- [common/CaptchaController.java](examples/CaptchaController.java) - Sample Controller
- [config/CyberTechBackground.java](examples/CyberTechBackground.java) - Custom Background
- [config/CyberTechNoise.java](examples/CyberTechNoise.java) - Custom Noise
