#import <React/RCTLog.h>
#import <React/RCTUIManager.h>
#import <React/RCTViewManager.h>

@interface RTNMyTimeViewManager : RCTViewManager
@end

@implementation RTNMyTimeViewManager

RCT_EXPORT_MODULE(RTNMyTimeView)
RCT_EXPORT_VIEW_PROPERTY(onTimePicked, RCTDirectEventBlock);

@end