package pl.com.chrzanowski.scma.domain;

public enum SocialProvider {

    LINKEDIN("linkedin");

    private String providerType;

    public String getProviderType() {
        return providerType;
    }

    SocialProvider(String providerType) {
        this.providerType = providerType;
    }
}
