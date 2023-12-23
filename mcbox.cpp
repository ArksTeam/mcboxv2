#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const char *nwjs_filename = "nw.exe 2>nul";

int main()
{
    int code = system(nwjs_filename);
    if (code == 0){
        return 0;
    }
    for(int i=0;i<30;i++){
        printf("*");
    }
    printf("\n\n---CRASH---\n程序崩溃了，请反馈Bug并允许开发人员远程控制您的电脑检查问题。\n");
    printf("The program crashes, please report the Bug and allow the developer to remotely control your computer to check the problem.\n");
    printf("Code: %d\n", code);
    while(1){
    }
    return 0;
}