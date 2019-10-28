close all;
original = imread('demoscropicImg1.jpg');

gray = rgb2gray(original);

BWG = imbinarize(gray);
BW = imcomplement(BWG);

subplot(2,3,1);
imshow(original);title('Original Image');

subplot(2,3,2);
imshow(BW);title('Binarised Image');

measurements = regionprops(BW, 'BoundingBox', 'Area' );

hold on
    for k=1:length(measurements)
         %CurrBB = measurements(k).BoundingBox;
         %
         thisBB = measurements(k).BoundingBox;
         %rectangle('Position',[thisBB(1),thisBB(2),thisBB(3),thisBB(4)], 'EdgeColor', 'r', 'LineWidth', 2);
         I2 = imcrop(original,[thisBB(1),thisBB(2),thisBB(3),thisBB(4)]);
         [rows, cols, depth]=size(I2);
         if rows*cols > 350
            %%%%%%%I2=imresize(I2,[28 28]);
            subplot(2,3,3);
            imshow(I2); title('cropped Image');
            cropedImage = I2;
        end
    end
hold off
geomFunc(cropedImage);
colorFunc(cropedImage);

%extracting geometrical properties
function geometricalProperties = geomFunc(cropedImage)
    geometricalProperties = regionprops('table',cropedImage,'Centroid',...
    'MajorAxisLength','MinorAxisLength');
    return;
end

%extracting color properties
function colorFunc(cropedImage)
    lab_he = rgb2lab(cropedImage);
    ab = lab_he;
    ab = im2single(ab);
    nColors = 2;
    % repeat the clustering 3 times to avoid local minima
    pixel_labels = imsegkmeans(ab,nColors,'NumAttempts',3);
    subplot(2,3,4);
    imshow(pixel_labels,[]); title('Image Labelling');
    
    %Clusters
    
    %cluster1
    mask1 = pixel_labels == 1;
    cluster1 = cropedImage .* uint8(mask1);
    subplot(2,3,5);
    imshow(cluster1); title('cluster1 objects');
    
     %cluster2
     mask2 = pixel_labels == 2;
     cluster2 = cropedImage.*uint8(mask2);
     subplot(2,3,6);
     imshow(cluster2);title('cluster2 objects');
     return;
end
