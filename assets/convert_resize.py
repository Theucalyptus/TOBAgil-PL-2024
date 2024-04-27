from PIL import Image
import os

directory="."

c=1
for filename in os.listdir(directory):
    if filename.endswith(".jpg"):
        im = Image.open(filename)
        name=filename+'.png'
        name = name.replace(".jpg", "")
        rgb_im = im.convert('RGB').resize([32, 32])
        rgb_im.save(name)
        print(os.path.join(directory, filename))
        continue
    else:
        continue