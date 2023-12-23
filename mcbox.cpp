#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

const char *nwjs_filename = "nw.exe 2>nul";

int main()
{
    HWND hwnd;
	hwnd=FindWindow("ConsoleWindowClass",NULL);
	if(hwnd)
	{
		ShowWindow(hwnd,SW_HIDE);
	}
    int code = system(nwjs_filename);
    if (code == 0){
        return 0;
    }
    MessageBox(NULL,"The program crashes, please report the Bug and allow the developer to remotely control your computer to check the problem.\n","CRASH",NULL);
    return code;
}
