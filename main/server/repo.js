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
        })
    });
}

class LCG {
    constructor(seed, a, c, m) {
        this.seed = seed;
        this.a = a;
        this.c = c;
        this.m = m;
    }

    next01() {
      this.seed = (this.a * this.seed + this.c) % this.m;
      return this.seed / this.m; // 将生成的数映射到[0, 1)区间上
    }
    nextInRange(min, max) {
    const range = max - min;
      return min + range * this.next01(); // 将[0, 1)区间上的数映射到[min, max)区间上
    }
}

function res(){
    const lcg = new LCG(42, 1664525, 1013904223, Math.pow(2, 32));
    const range = lcg.nextInRange(1, 2);
    if(range<0.5){
        window.open('https://bbs.minecraftbox.link');
    }else{
        window.open('https://flarum.minecraftbox.link')
    }

}

function signup(){res();}
function report(){res();}