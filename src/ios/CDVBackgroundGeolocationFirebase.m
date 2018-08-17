////
//  CDVBackgroundGeoLocation
//
//  Created by Chris Scott <chris@transistorsoft.com> on 2013-06-15
//  Largely based upon http://www.mindsizzlers.com/2011/07/ios-background-location/
//
#import "CDVBackgroundGeolocationFirebase.h"

static NSString *const TAG = @"CDVBackgroundGeolocationFirebase";


@implementation CDVBackgroundGeolocationFirebase
{
    BOOL enabled;
    BOOL configured;
}

- (void)pluginInitialize
{
    configured = NO;
}

- (void) configure:(CDVInvokedUrlCommand*)command
{    
    NSDictionary *config = [command.arguments objectAtIndex:0];
    
}

- (void)dealloc
{

}

@end

