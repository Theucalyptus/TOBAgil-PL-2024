from PIL import Image
import os

directory="."
SIZE=32

c=1
for filename in os.listdir(directory):
    if filename.endswith(".png"):
        im = Image.open(filename)
        im = im.resize([32, 32])
        im.save(filename)
        print(os.path.join(directory, filename))
        continue
    else:
        continue