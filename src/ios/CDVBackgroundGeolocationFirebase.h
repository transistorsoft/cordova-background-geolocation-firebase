//
//  CDVBackgroundGeoLocation.hs
//
//  Created by Chris Scott <chris@transistorsoft.com>
//

#import <Cordova/CDVPlugin.h>

@interface CDVBackgroundGeolocationFirebase : CDVPlugin

@property (nonatomic) NSString* locationsCollection;
@property (nonatomic) NSString* geofencesCollection;
@property (nonatomic) BOOL updateSingleDocument;

- (void) configure:(CDVInvokedUrlCommand*)command;

@end

