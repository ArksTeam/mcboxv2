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
        self.label.pack(pady=50)

        self.button1 = tk.Button(self, text="资源中心 Download Map", command=self.on_button1_click)
        self.button1.pack()
        self.button2 = tk.Button(self, text="论坛 BBS", command=self.on_button2_click)
        self.button2.pack()

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