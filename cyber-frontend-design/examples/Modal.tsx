import React from "react";
import { X } from "lucide-react";

interface ModalProps {
  isOpen: boolean;
  onClose: () => void;
  title: React.ReactNode;
  children: React.ReactNode;
  maxWidth?: string;
}

export const Modal: React.FC<ModalProps> = ({
  isOpen,
  onClose,
  title,
  children,
  maxWidth = "max-w-lg",
}) => {
  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-slate-900/50 backdrop-blur-sm animate-in fade-in duration-200">
      <div
        className={`bg-white rounded-2xl shadow-2xl w-full ${maxWidth} overflow-hidden border border-slate-100 animate-in zoom-in-95 duration-200 flex flex-col max-h-[90vh]`}
      >
        <div className="px-6 py-4 border-b border-slate-100 flex items-center justify-between bg-slate-50/50 shrink-0">
          <h3 className="text-lg font-bold text-slate-800 flex items-center gap-2">
            {title}
          </h3>
          <button
            onClick={onClose}
            className="text-slate-400 hover:text-slate-600 transition-colors bg-white hover:bg-slate-100 p-1.5 rounded-lg border border-slate-200"
          >
            <X size={18} />
          </button>
        </div>
        <div className="overflow-y-auto flex-1 bg-white">{children}</div>
      </div>
    </div>
  );
};
