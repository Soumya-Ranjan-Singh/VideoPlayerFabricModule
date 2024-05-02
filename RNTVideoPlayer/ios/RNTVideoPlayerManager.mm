#import <React/RCTLog.h>
#import <React/RCTUIManager.h>
#import <React/RCTViewManager.h>

@interface RNTVideoPlayer : RCTViewManager
@end

@implementation RNTVideoPlayerManager

RCT_EXPORT_MODULE(RNTVideoPlayer)

RCT_EXPORT_VIEW_PROPERTY(url, NSString)

@end