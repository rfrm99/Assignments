import json

file = "jsonwrite.json"

def save_file(sfile, twt):
    with open(sfile, "w") as f:
        f.write(json.dumps(twt, indent=4))


def load_file(lfile):
    with open(lfile,'r') as f:
         return json.loads(f.read())

def posttweet(tweet, uname):
    tweets["tweets"].append({"tweet": tweet, "uname": uname,})
    save_file(file, tweets)

tweets = load_file(file)

def tweeting():
    print("What do you want to do?")
    choice = input("post or print Tweet?")
    if choice == "post":
        uname = input("Enter username? ")
        tweet = input("Enter Tweet >>> ")
        posttweet(uname, tweet)
    elif choice == "print":
        for tweet in tweets["tweets"]:
            print(f'{tweet["uname"]}:', tweet["tweet"])
    else:
        print("please input either post or print")
        tweeting()

tweeting()

