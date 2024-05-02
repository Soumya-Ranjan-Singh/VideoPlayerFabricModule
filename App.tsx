import React from 'react';
import {View, Text, StyleSheet} from 'react-native';
import RNTVideoPlayerNativeComponent from './RNTVideoPlayer/js/RNTVideoPlayerNativeComponent';

const App = () => {
  return (
    <View style={styles.container}>
      {/* <Text>Home</Text> */}
      {/* {pipMode ? (
        <Video
          source={{uri: routedata.videoUrl}}
          ref={videoRef}
          resizeMode="contain"
          style={{flex: 1}}
          playInBackground={false}
        />
      ) : (
        <VideoPlayer
          source={{uri: routedata.videoUrl}}
          ref={videoRef}
          controls={true}
          resizeMode="stretch"
          fullscreen={false}
          fullscreenAutorotate={true}
          fullscreenOrientation="landscape"
          pictureInPicture
          videoStyle={{flex: 1}}
          navigator={navigation}
          onBack={() => {
            navigation.goBack();
            //Orientation.getDeviceOrientation();
          }}
          //onEnterFullscreen={() => onFullScreen(true)}
          //onExitFullscreen={() => onFullScreen(false)}
        />
        // <VlCPlayerView
        //   autoplay={false}
        //   url={videoUrl}
        //   Orientation={Orientation}
        //   ggUrl=""
        //   showGG={true}
        //   showTitle={true}
        //   title="Big Buck Bunny"
        //   showBack={true}

        //   //ref={videoRef}
        // />
        // <VLCPlayer
        //   style={[{flex: 1}]}
        //   videoAspectRatio="16:9"
        //   source={{uri: videoUrl}}

        //   //ref={videoRef}
        // />
      )} */}
      <RNTVideoPlayerNativeComponent
        url={
          'https://maven-543.s3.ap-south-1.amazonaws.com/test/hgliQiMmLa_SampleVideo_1280x720_30mb.mp4'
        }
        style={{flex: 1}}
      />
    </View>
  );
};

export default App;

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});

// const data: any[] = [
//   'https://maven-543.s3.ap-south-1.amazonaws.com/test/hgliQiMmLa_SampleVideo_1280x720_30mb.mp4',
//   'https://maven-543.s3.ap-south-1.amazonaws.com/test/BskKhzzdQz_4267245-uhd_3840_2160_30fps.mp4',
//   'https://www.pagalworld.com.sb/files/download/id/70608',
// ];
