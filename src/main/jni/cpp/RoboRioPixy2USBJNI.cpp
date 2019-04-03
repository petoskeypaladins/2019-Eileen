// // THIS IS BROKEN (I TRIED TO FIX IT AND EVERYTHING SHOWED AS AN ERROR)
// //
// // begin license header
// //
// // This file is part of Pixy CMUcam5 or "Pixy" for short
// //
// // All Pixy source code is provided under the terms of the
// // GNU General Public License v2 (http://www.gnu.org/licenses/gpl-2.0.html).
// // Those wishing to use Pixy source code, software and/or
// // technologies under different licensing terms should contact us at
// // cmucam@cs.cmu.edu. Such licensing terms are available for
// // all portions of the Pixy codebase presented here.
// //
// // end license header
// //
// #include <jni.h>
// #include <iostream>
// #include <sstream>
// #include <thread>
// #include <chrono>

// #include "frc_robot_vision_Pixy2USBJNI.h"
// #include "libpixyusb2.h"

// #include <cscore.h>
// #include <opencv2/core/core.hpp>
// #include <opencv2/imgproc/imgproc.hpp>
// #include <opencv2/highgui/highgui.hpp>
// #include <opencv2/opencv.hpp>
// #include <opencv2/objdetect/objdetect.hpp>
// #include <vector>
// #include <networktables/NetworkTable.h>
// using namespace cv;
// using namespace std;

// // #include <opencv2/highgui/highgui.hpp>
// // #include <opencv2/imgproc/imgproc.hpp>
// // #include <opencv2/core/core.hpp>


// Pixy2 pixy;
// uint8_t *bayerFrame;
// cv::Mat bayerMat(PIXY2_RAW_FRAME_HEIGHT, PIXY2_RAW_FRAME_WIDTH, CV_8U);
// cv::Mat output(PIXY2_RAW_FRAME_HEIGHT, PIXY2_RAW_FRAME_WIDTH, CV_8UC3);
// Mat img, thresholded;
// shared_ptr<NetworkTable> table;
// JNIEXPORT jint JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBInit(JNIEnv *env, jobject thisObj) {
//    std::cout << "pixy2 usb init" << std::endl;
//    return pixy.init();
// }

// JNIEXPORT void JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBGetVersion(JNIEnv *env, jobject thisObj) {
//    std::cout << "pixy2 usb get version" << std::endl;
//    pixy.version->print();
//    return;
// }

// JNIEXPORT void JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBLampOn(JNIEnv *env, jobject thisObj) {
//    std::cout << "pixy2 usb Lamp On" << std::endl;
//    pixy.setLamp(0x01, 0x00);
//    return;
// }

// JNIEXPORT void JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBLampOff(JNIEnv *env, jobject thisObj) {
//    std::cout << "pixy2 usb Lamp Off" << std::endl;
//    pixy.setLamp(0x00, 0x00);
//    return;
// }

// CS_Source source;

// JNIEXPORT void JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBInitCameraServer
//   (JNIEnv *env, jobject, jint csHandle) {
//      source = static_cast<CS_Source>(csHandle);
// }

// JNIEXPORT jint JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBLoopCameraServer(JNIEnv *env, jobject thisObj)
// {
//    // need to call stop() before calling getRawFrame().
//    // Note, you can call getRawFrame multiple times after calling stop().
//    // That is, you don't need to call stop() each time.
//    pixy.m_link.stop();

//    // grab raw frame, BGGR Bayer format, 1 byte per pixel
//    pixy.m_link.getRawFrame(&bayerFrame);
//    // convert Bayer frame to RGB frame
//    bayerMat.data = bayerFrame;

//    // Using OpenCV for conversion to RGB
//    cv::cvtColor(bayerMat, thresholded, cv::COLOR_BayerBG2RGB);






// 				vector < vector<Point> > contours;
// 				vector<Vec4i> hierarchy;


// 				findContours(thresholded, contours, hierarchy, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_SIMPLE, Point(0, 0));


// 				if (contours.size() > 0) {

// 					cout << contours.size() << " contours" << endl;

// 					vector <Point> targetContour = contours[0];

// 					for (unsigned int i = 1; i < contours.size(); i++) {
// 						if (contourArea(contours[i]) > contourArea(targetContour)) {
// 							targetContour = contours[i];
// 						}
// 					}

// 					Mat drawing = Mat::zeros( thresholded.size(), CV_8UC3 );
// 					Scalar color = Scalar( 255, 255, 255);

// 					vector <Point> hull;

// 					convexHull(targetContour, hull, false);

// 					vector <vector <Point> > tmpHull(1, hull);


// 					cout << "hull size " << hull.size() << endl;


// 					vector <Point> corners(4, Point(0,0));
// 					vector <int>  cornerSq(4);
// 					int TOP_LEFT = 0;
// 					int TOP_RIGHT = 1;
// 					int BOTTOM_RIGHT = 2;
// 					int BOTTOM_LEFT = 3;

// 					for (unsigned int i = 0; i < corners.size(); i++) {
// 						corners[i] = hull[0];
// 						if (i < 2)
// 						  cornerSq[i] = hull[0].x * hull[0].y;
// 						else
// 						  cornerSq[i] = (img.cols - hull[0].x) * hull[0].y;
// 					}

// 					for (unsigned int i = 1; i < hull.size(); i++) {

// 						cout << "hull " << i << ": (" << hull[i].x << ", " << hull[i].y << ") ";
// 						int thisSq = hull[i].x * hull[i].y;

// 						if (thisSq < cornerSq[TOP_LEFT]) {
// 							corners[TOP_LEFT] = hull[i];
// 							cornerSq[TOP_LEFT] = thisSq;
// 						}
// 						if (thisSq > cornerSq[BOTTOM_RIGHT]) {
// 							corners[BOTTOM_RIGHT] = hull[i];
// 							cornerSq[BOTTOM_RIGHT] = thisSq;
// 						}

// 						thisSq = (img.cols - hull[i].x) * hull[i].y;

// 						if (thisSq < cornerSq[TOP_RIGHT]) {
// 							corners[TOP_RIGHT] = hull[i];
// 							cornerSq[TOP_RIGHT] = thisSq;
// 						}
// 						if (thisSq > cornerSq[BOTTOM_LEFT]) {
// 							corners[BOTTOM_LEFT] = hull[i];
// 							cornerSq[BOTTOM_LEFT] = thisSq;
// 						}
// 					}

// 					cout << endl;


// 					for (unsigned int i = 0; i < corners.size(); i++) {
// 						circle(drawing, corners[i], 4, Scalar(0, 0, 255), 1, 8, 0);
// 					}

// 					//Easier equations that will average out the points
// 					double cenX1 = fabs(((double)(corners[TOP_RIGHT].x - corners[TOP_LEFT].x)) / 2);
// 					double cenX2 = fabs(((double)(corners[BOTTOM_RIGHT].x - corners[BOTTOM_LEFT].x)) / 2);
// 					double cenX = ((double) (cenX1 + cenX2) / 2) + corners[TOP_LEFT].x;

// 					double cenY1 = fabs(((double)(corners[TOP_RIGHT].y - corners[BOTTOM_RIGHT].y)) / 2);
// 					double cenY2 = fabs(((double)(corners[TOP_LEFT].y - corners[BOTTOM_LEFT].y)) / 2);
// 					double cenY = ((double) (cenY1 + cenY2) / 2) + corners[TOP_LEFT].y;

// 					//Code to calculate area, and eliminate the smallest contours

// 					double wx1 = corners[BOTTOM_RIGHT].x - corners[BOTTOM_LEFT].x;
// 					double wy1 = corners[BOTTOM_RIGHT].y - corners[BOTTOM_LEFT].y;

// 					double hx1 = corners[TOP_RIGHT].x - corners[BOTTOM_RIGHT].x;
// 					double hy1 = corners[TOP_RIGHT].y - corners[BOTTOM_RIGHT].y;

// 					double wx2 = pow(wx1, 2);
// 					double wy2 = pow(wy1, 2);

// 					double hx2 = pow(hx1, 2);
// 					double hy2 = pow(hy1, 2);

// 					double dist1 = sqrt(wx2 + wy2);
// 					double dist2 = sqrt(hx2 + hy2);

// 					double area = dist1 * dist2;

// 					cout << "Area: " << area << endl;

// 					if (area < 99) {
// 						// Do something here
// 					}

// 					table->PutNumber("Goal Width", dist1);

// 					table->PutNumber("Center X", cenX);
// 					table->PutNumber("Center Y", cenY);

// 					drawContours(drawing, tmpHull, 0, color, 1, 8, hierarchy, 0, Point(0, 0) );
// 					circle(drawing, Point(((int) round(cenX)), ((int) round(cenY))), 4, Scalar(0, 255, 0), 1, 8, 0);
// 					line(drawing, corners[TOP_LEFT], corners[BOTTOM_RIGHT], Scalar(255, 0, 0), 1, 8, 0);
// 					line(drawing, corners[TOP_RIGHT], corners[BOTTOM_LEFT], Scalar(255, 0, 0), 1, 8, 0);

// 					drawContours(img, tmpHull, 0, color, 1, 8, hierarchy, 0, Point(0, 0) );
// 					circle(img, Point(((int) round(cenX)), ((int) round(cenY))), 4, Scalar(0, 255, 0), 1, 8, 0);
// 					line(img, corners[TOP_LEFT], corners[BOTTOM_RIGHT], Scalar(255, 0, 0), 1, 8, 0);
// 					line(img, corners[TOP_RIGHT], corners[BOTTOM_LEFT], Scalar(255, 0, 0), 1, 8, 0);
// 					for (unsigned int i = 0; i < 4; i++) {
// 						circle(img, Point(((int) round(cenX)), ((int) round(cenY) - 75 - (25 * i))), 4, Scalar(0, 0, 255), 1, 8, 0);
// 					}

// 					imwrite("/var/local/natinst/www/capture.png", drawing);
// 				} else {
// 					cout << "can't find contours" << endl;
// 					int NO_CONTOURS = -1;
// 					table->PutNumber("Center X", NO_CONTOURS);
// 					table->PutNumber("Center Y", NO_CONTOURS);
// 				}









//    // Call resume() to resume the current program, otherwise Pixy will be left in "paused" state.
//    pixy.m_link.resume();

//    CS_Status status = 0;
//    cs::PutSourceFrame(source, output, &status);
//    return status;
// }