import os
import sys
import time

if len(sys.argv) != 2:
    print(f'''
        mcboxv2 apple auto build
        Usage:
        {sys.argv[0]} [system]

        - system:
            - ios
            - mac
    ''')
    sys.exit(1)

system = sys.argv[1]
if system == 'ios':
    print('IOS does not support direct deployment. Please manually package ios.html into an IPA file.')
    sys.exit(1)

elif system == 'mac':
    start_time = time.time()
    os.system('pip install pyinstaller')
    os.system('python -m pyinstaller macos.py')
    end_time = time.time()
    elapsed_time = end_time - start_time
    print(f'[Done] Deployment completed in {elapsed_time:.2f} seconds.')
    sys.exit(0)

else:
    print(f'Error: Invalid system "{system}". Please select either "ios" or "mac".')
    sys.exit(1)