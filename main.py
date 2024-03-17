import os
import time
import _thread
from flask import Flask, send_from_directory, abort

app = Flask(__name__)

def pull():
    os.system("git clone -b android https://github.com/ArksTeam/mcboxv2.git")
    time.sleep(10)

@app.route('/')
def index():
    try:
        return send_from_directory('.', 'index.html')
    except FileNotFoundError:
        abort(404)

@app.route('/<path:filename>')
def serve_file(filename):
    try:
        if '..' in filename:
            abort(403)
        file_path = os.path.abspath(os.path.join('.', filename))
        if not file_path.startswith(os.path.abspath('.')):
            abort(403)
        if not os.path.isfile(file_path):
            abort(404)
        return send_from_directory('.', filename)
    except Exception as e:
        print(e)
        abort(500)

if __name__ == '__main__':
    _thread.start_new_thread(pull, ())
    app.run()
