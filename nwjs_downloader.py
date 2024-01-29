import urllib.request
import zipfile

URL = 'https://dl.nwjs.io/v0.80.0/nwjs-v0.80.0-win-x64.zip'

with open('nwjs-win-x64.zip','w') as nwjs:
  nwjs.write(urllib.request.urlopen(URL))
  
zip_file = zipfile.ZipFile('nwjs-win-x64.zip')
zip_extract = zip_file.extractall()
zip_extract.close()
