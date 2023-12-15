import tkinter as tk
import webbrowser
import sys

class Application(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("多玩我的世界盒子")
        self.geometry("500x200")

        self.configure(bg="#eef2f6")  # 设置应用程序的背景色

        self.label = tk.Label(self, text="多玩我的世界盒子")
        self.label.pack(anchor="nw", padx=10, pady=10)

        self.button1 = tk.Button(self, text="资源中心 Download Map")
        self.button1.config(width=25, bg="#ABCDEF", bd=0, anchor="w")
        self.button1.pack(side="top", padx=10, pady=10)

        self.button2 = tk.Button(self, text="论坛 BBS")
        self.button2.config(width=25, bg="#ABCDEF", bd=0, anchor="w")
        self.button2.pack(side="top", padx=10, pady=10)

        self.button1.config(command=self.on_button1_click)
        self.button2.config(command=self.on_button2_click)

    def on_button1_click(self):
        webbrowser.open("https://remcbox.flarum.cloud")

    def on_button2_click(self):
        webbrowser.open("https://bbs.example.com")

def main() -> int:
    app = Application()
    app.mainloop()
    return 0

if __name__ == "__main__":
    code = main()
    sys.exit(code)