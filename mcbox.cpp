#include <fstream>
#include <iostream>

int main(){
    const std::string nwjs_binfile = "nwjs.exe";
    int code;
    code = system(nwjs_binfile);
    if(code != 0){
        std::cerr << "Uhhhh......" << endl;
        try{
            ofstream outfile;
            outfile.open("logs.log", ios::out | ios::trunc );
            outfile << std::string to_string(code) << endl;
            outfile.close()
            std::cerr << "看起来程序崩溃了。请在下一次启动点击\"反馈Bug\"并将logs.log的日志发送。" << endl;
        }catch(...){
            std::cerr << "看起来程序崩溃了。请在下一次启动点击\"反馈Bug\"，如果您愿意的话，可以让开发人员远程控制您的电脑检查Bug." << endl;
        }
        std::cerr << "真的很对不起！按Ctrl+C关闭错误窗口。" << endl;
        while (true){

        }
    }
    return 0;
}