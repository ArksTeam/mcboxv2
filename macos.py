import tkinter as tk
import webbrowser
import sys

class Application(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("多玩我的世界盒子")
        self.geometry("500x200")

        self.label = tk.Label(self, text="多玩我的世界盒子")
        self.label.pack(pady=50)

        self.button = tk.Button(self, text="资源中心 Download Map", command=self.on_button_click)
        self.button.pack()
        self.button = tk.Button(self, text="论坛 BBS", command=self.on_button_click)
        self.button.pack()

    def on_button_click(self):
        webbrowser.open("https://remcbox.flarum.cloud")

def main() -> int:
    app = Application()
    app.mainloop()
    return 0

if __name__ == "__main__":
    code = main()
    sys.exit(code)
