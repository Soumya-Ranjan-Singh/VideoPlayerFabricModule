#import "RNTVideoPlayer.h"

#import <react/renderer/components/RNTVideoPlayerSpecs/ComponentDescriptors.h>
#import <react/renderer/components/RNTVideoPlayerSpecs/EventEmitters.h>
#import <react/renderer/components/RNTVideoPlayerSpecs/Props.h>
#import <react/renderer/components/RNTVideoPlayerSpecs/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"

using namespace facebook::react;

@interface RNTVideoPlayer () <RCTRNTVideoPlayerViewProtocol>
@end

@implementation RNTVideoPlayer {
    UIView *_view;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<RNTVideoPlayerComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const RNTVideoPlayerProps>();
        _props = defaultProps;

        _view = [[UIView alloc] init];
        _view.backgroundColor = [UIColor redColor];


        // _label = [[UILabel alloc] init];
        // _label.text = @"Initial value";
        // [_view addSubview:_label];

        // _label.translatesAutoresizingMaskIntoConstraints = false;
        // [NSLayoutConstraint activateConstraints:@[
        //     [_label.leadingAnchor constraintEqualToAnchor: _view.leadingAnchor],
        //     [_label.topAnchor constraintEqualToAnchor: _view.topAnchor],
        //     [_label.trailingAnchor constraintEqualToAnchor: _view.trailingAnchor],
        //     [_label.bottomAnchor constraintEqualToAnchor: _view.bottomAnchor],
        // ]];

        // _label.textAlignment = NSTextAlignmentCenter;

        self.contentView = _view;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<RNTVideoPlayerProps const>(_props);
    const auto &newViewProps = *std::static_pointer_cast<RNTVideoPlayerProps const>(props);

    if (oldViewProps.url != newViewProps.url) {
        NSURL *videoURL = [NSURL URLWithString:[[NSString alloc] initWithCString:newViewProps.url.c_str() encoding:NSASCIIStringEncoding]];
        AVPlayer *player = [AVPlayer playerWithURL:videoURL];

        //create a player view controller
        AVPlayerViewController *controller = [[AVPlayerViewController alloc] init];
        UIViewController* vc = RCTPresentedViewController();
        [vc presentViewController:controller animated:YES completion:nil];
        controller.player = player;
        [player play];
    }

    [super updateProps:props oldProps:oldProps];
}

@end

Class<RCTComponentViewProtocol> RNTVideoPlayerCls(void)
{
    return RNTVideoPlayer.class;
}