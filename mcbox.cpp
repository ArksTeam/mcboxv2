#include <fstream>
#include <iostream>

int main(){
    const std::string nwjs_binfile = "nwjs.exe";
    int code = system(nwjs_binfile.c_str());
    if(code != 0){
        std::cerr << "程序崩溃了，请查看logs.log文件并反馈Bug。" << std::endl;
        try{
            std::ofstream outfile("logs.log");
            outfile << std::to_string(code) << std::endl;
            outfile.close();
        }catch(...){
            std::cerr << "程序崩溃了，请反馈Bug并允许开发人员远程控制您的电脑检查问题。" << std::endl;
        }
        std::cerr << "按Ctrl+C关闭错误窗口。" << std::endl;
        while (true){

        }
    }
    return 0;
}