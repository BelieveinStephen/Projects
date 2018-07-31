'''
    This is basically a small python script that, given a text document, it provides
    a "cohesion" index based on shingles, a "coherence" index and the Automated Readability Index
'''
import sys

test1 = '''Unlike the other indices, the ARI, along with the Coleman-Liau, relies on a factor of characters per word, instead of the usual syllables per word. Although opinion varies on its accuracy as compared to the syllables/word and complex words indices, characters/word is often faster to calculate, as the number of characters is more readily and accurately counted by computer programs than syllables. In fact, this index was designed for real-time monitoring of readability on electric typewriters.''' #~17.44


test2='''By late 1941, Turing and his fellow cryptanalysts Gordon Welchman, Hugh Alexander, and Stuart Milner-Barry were frustrated. Building on the brilliant work of the Poles, they had set up a good working system for decrypting Enigma signals but they only had a few people and a few bombes so they did not have time to translate all the signals. In the summer they had had considerable success and shipping losses had fallen to under 100,000 tons a month but they were still on a knife-edge. They badly needed more resources to keep abreast of German adjustments. They had tried to get more people and fund more bombes through the proper channels but they were getting nowhere. Finally, breaking all the rules, on 28 October they wrote directly to Winston Churchill spelling out their difficulties, with Turing as the first named. They emphasised how small their need was compared with the vast expenditure of men and money by the forces and compared with the level of assistance they could offer to the forces''' #~13.8



def ari(text):
    if text[-1]==".":
        text = text[:-1]
    sent = len(text.split("."))
    words=float(len(text.split(" "))-1)
    characters = len(text)-words
    #print sent,words,characters
    return 4.71*(characters/words)+0.5*(words/sent)-21.43


def clean(text):
    return text.replace(",","").replace("?",".").replace("'"," '").replace("!",".")


def sim(s1,s2):
    ss1 = s1.split(" ")
    ss2 = s2.split(" ")
    overlap=sum(1 for x in ss1 if x in ss2)
    return overlap


def avg(l):
    return sum(l)/float(len(l)+0.00001)
    
    
def word_overlap(parag):
    text = clean(parag)
    sents = text.split(".")
    sims = [sim(x,y) for x,y in zip(sents[:-1],sents[1:])]
    return avg(sims)


def coherence(text):
    paras = [p for p in text.split("\n") if len(p)>3]
    overlap = [word_overlap(p) for p in paras]
    return avg(overlap)


def eval_text(text):
    return ari(text), coherence(text)
    
    
if __name__=="__main__":
   filename = sys.argv[1]
   text = open(filename).read()
   text=unicode(text,errors="replace")
   print eval_text(text)
