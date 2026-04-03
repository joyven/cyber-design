/**
 * Cyber-Tech Theme Configuration
 * 赛博科技主题统一配置
 * 
 * 强制约束：所有 UI 各项数值必须从此处获取，严禁硬编码。
 */
export const THEME = {
  // 核心色调 (Core Colors)
  COLORS: {
    PRIMARY: "#25ADB5",      // 青翠色 (Cyan-Teal)
    PRIMARY_HOVER: "#1e8e94",
    SECONDARY: "#f1f5f9",    // 浅灰色 (Slate-100)
    SECONDARY_HOVER: "#e2e8f0",
    TEXT_MAIN: "#1e293b",    // 深灰色 (Slate-800)
    TEXT_MUTED: "#64748b",   // 辅助文字 (Slate-500)
    DANGER: "#ef4444",       // 危险 (Red-500)
    WARNING: "#f59e0b",      // 警告 (Amber-500)
    SUCCESS: "#10b981",      // 成功 (Emerald-500)
    BORDER: "#f1f5f9",       // 边框色 (Slate-100)
    BG_LIGHT: "#f8fafc",     // 浅背景 (Slate-50/50)
  },

  // 几何属性 (Geometry)
  RADIUS: "rounded-xl",      // 12px 大圆角 (Standard Roundness)
  
  // 动效与交互 (Interactions)
  TRANSITION: "transition-all duration-200",
  ACTIVE_SCALE: "active:scale-95",
  
  // 阴影 (Shadows)
  SHADOW: "shadow-lg shadow-cyan-100/50",

  // 基础组件原子类组合 (Atomic Combinations)
  COMPONENTS: {
    // 主按钮 (Primary Button)
    BUTTON_PRIMARY: "bg-[#25ADB5] text-white rounded-xl text-sm font-bold shadow-lg shadow-cyan-100/50 active:scale-95 transition-all hover:bg-[#1e8e94]",
    // 次按钮 (Secondary Button)
    BUTTON_SECONDARY: "bg-slate-100 text-slate-600 rounded-xl text-sm font-bold hover:bg-slate-200 transition-colors",
    // 输入框 (Input Field)
    INPUT: "w-full h-10 px-3 bg-slate-50 border border-slate-200 rounded-xl text-sm focus:outline-none focus:border-[#25ADB5] transition-colors",
    // 标签容器 (Tab/Card Header)
    HEADER: "px-6 py-4 border-b border-slate-100 bg-slate-50/50",
  }
} as const;
