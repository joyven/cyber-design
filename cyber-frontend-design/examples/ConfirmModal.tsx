import React from "react";
import { AlertCircle } from "lucide-react";

interface ConfirmModalProps {
  isOpen: boolean;
  title?: string;
  message: React.ReactNode;
  onConfirm: () => void;
  onCancel: () => void;
  confirmText?: string;
  cancelText?: string;
  confirmButtonClass?: string;
}

export const ConfirmModal: React.FC<ConfirmModalProps> = ({
  isOpen,
  title = "系统提示",
  message,
  onConfirm,
  onCancel,
  confirmText = "确定",
  cancelText = "取消",
  confirmButtonClass = "bg-red-500 hover:bg-red-600 shadow-red-100", // 默认危险操作红
}) => {
  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 z-[150] flex items-center justify-center p-4 bg-slate-900/50 backdrop-blur-sm">
      <div className="bg-white rounded-2xl shadow-2xl w-full max-w-sm overflow-hidden border border-slate-100 animate-in fade-in zoom-in duration-200">
        <div className="px-6 py-4 border-b border-slate-100 flex items-center gap-2 bg-slate-50/50">
          <AlertCircle size={18} className="text-amber-500" />
          <h3 className="text-base font-bold text-slate-800">{title}</h3>
        </div>
        <div className="p-6 text-sm text-slate-600 leading-relaxed">
          {message}
        </div>
        <div className="px-6 py-4 bg-slate-50/50 border-t border-slate-100 flex justify-end gap-3">
          <button
            onClick={onCancel}
            className="px-6 py-2 text-sm font-bold text-slate-600 bg-slate-100 hover:bg-slate-200 rounded-xl transition-colors"
          >
            {cancelText}
          </button>
          <button
            onClick={onConfirm}
            className={`px-6 py-2 text-sm font-bold text-white rounded-xl transition-all shadow-lg active:scale-95 ${confirmButtonClass}`}
          >
            {confirmText}
          </button>
        </div>
      </div>
    </div>
  );
};
