from keras.preprocessing.image import ImageDataGenerator, array_to_img, img_to_array, load_img
import cv2
import os

datagen = ImageDataGenerator(
        rotation_range=20,
        shear_range=0.2,
        zoom_range=0.0,
        fill_mode='nearest')

input_folder_list = ["hindi","odia"]
# Traverse through all files in the language folder and read data
for folder in input_folder_list:
    subfolders = os.listdir("./" + folder)
    for subfolder in subfolders:
        images = os.listdir("./" + folder + "/" + subfolder)
# lots of preprocessing were required to achieve good accuracy(86%)
        for image in images:
            img = cv2.imread("./" + folder + "/" + subfolder + "/" + image, cv2.IMREAD_GRAYSCALE)
            x = img_to_array(img)  # this is a Numpy array with shape (3, 150, 150)
            x = x.reshape((1,) + x.shape)  # this is a Numpy array with shape (1, 3, 150, 150)

# the .flow() command below generates batches of randomly transformed images
# and saves the results to the `preview/` directory
            pat = "preview\\"+folder+"\\"+subfolder
            i = 0
            for batch in datagen.flow(x, batch_size=1,
                          save_to_dir=pat, save_format='jpeg'):
                i += 1
                if i > 5:
                    break 
   

        
print "END"