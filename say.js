const { exec } = require('child_process');

function startGame(){
    var startFlagFileName = "startFlag.txt";
    var fs = require("fs");
    fs.exists(startFlagFileName, function(exists) {
        if(!exists){
            var startGameFileName = prompt("请输入您的第三方启动器目录(如有参数请附加)：");
            fs.writeFile(startFlagFileName, startGameFileName, function(err){})
        }
        var starterName;
        fs.readFile(startFlagFileName,function(err, data){
            starterName = data.toString();
        })
        exec(starterName,(err, stdout, stderr) => {
            if(err){
                alert('Crash on 15 lines: Cannot run command.')
                return -1;
            }
            console.log(`stdout: ${stdout}`);
            console.log(`stderr: ${stderr}`);
        })
    });
}

function res(){
    window.open("https://bbs.minecraftbox.link/");
}

function signup(){res();}
function report(){res();}