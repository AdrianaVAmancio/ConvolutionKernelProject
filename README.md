
Course: Science Computing  - Software Development (GMIT)
Module: Object Oriented Software Development
PROJECT: Filtering an Image with a Convolution Kernel

DESCRIPTION

Project developed as part of the module Object Oriented Software Development, in the H. Dip. In Science (Software Development) course at GMIT. 

This project aim to present an application able to do image processing using Convolution Kernel, what consist of a 2D array that reads an image pixel by pixel, applying the filters pre-defined in the Matrix  choosen by the users, and afterward present an output with this Ònew imageÓ after the process.

The application was develop using Java IDE on Eclipse.

SEETINGS

When run the application on Terminal/Command Prompt it will show the user an inicial Menu with the options available:

- Adding an Image: to add an image in the app Database the user must use the image full path, then when the image is add into the Database the program will generate an ID for that image, the user can add multiple images, with a maximal capacity of 20, and each one will get and ID in order within it entry in the Database (1, 2, 3, 4, and so on);

- Deleting: to delete an image the user can do it easily by selecting the option 2 in the main Menu, then enter the image ID;

- Applying Kernel Filter: to apply the filters the user can do it be selecting option 5, then the app ask will ask to select a filter and then on which file the user want to apply the filter, the answer must be a number representing the image ID. 

After that application will process the image and create a folder named ÒoutputFileNameÓ in the user Desktop where the src file is.
